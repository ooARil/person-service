package liga.medical.personservice.core.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.security.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Api(value = "API для работы пользователя с уровнем доступа ADMIN")
public class AdminController {

    private final UserServiceImpl userService;

    @GetMapping("/admin")
    @ApiOperation(value = "Получение списка всех пользователей из базы")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "admin";
    }

    @PostMapping("/admin")
    @ApiOperation(value = "Удаление пользователей из базы")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                              @RequestParam(required = true, defaultValue = "") String action,
                              Model model) {
        if ("delete".equals(action)) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}