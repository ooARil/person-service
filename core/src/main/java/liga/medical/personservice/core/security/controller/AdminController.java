package liga.medical.personservice.core.security.controller;

import liga.medical.personservice.core.security.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                              @RequestParam(required = true, defaultValue = "") String action,
                              Model model) {
        if ("delete".equals(action)) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
