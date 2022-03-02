package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserServiceImpl;
import web.model.User;


@Controller
public class UserController {


    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    // дофолтное отображение
    @GetMapping(value = "/")
    public String welcome() {
        return "test";
    }

    // показать всех пользователей
    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());

        return "users";
    }


    // вызвать форму добавления пользователя
    @GetMapping("/users/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUserForm";
    }

    // добавить пользователя в базу из формы
    @PostMapping("users/add")
    public String userAddProcess(@RequestParam String name, @RequestParam String email,
                                 @RequestParam String pass, Model model) {
        userService.userAdd(name, email, pass);
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    // вызвать форму рездактирования пользователя
    @GetMapping("users/edit/{id}")
    public String showUserEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    // обработать данные из формы редактирования пользователя
    @PostMapping("users/edit/{id}")
    public String userEditProcess(@PathVariable(value = "id") int id,
                                  @RequestParam String name, @RequestParam String email,
                                  @RequestParam String pass) {
        userService.userEdit(id, name, email, pass);
        return "redirect:/users";
    }

    // удаление пользователя из базы
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        userService.delete(userService.getById(id));
        return "redirect:/users";
    }
}