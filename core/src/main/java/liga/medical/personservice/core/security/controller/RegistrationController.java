package liga.medical.personservice.core.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.security.entity.User;
import liga.medical.personservice.core.security.service.api.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Api(value = "API для регистрации и валидации нового пользователя")
public class RegistrationController {

    private final UserServise userService;
    private final UserValidator userValidator;

    @PostMapping("/registration")
    @ApiOperation(value = "Валидация регистрации пользователя и занесение его в базу")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/";
    }

    @GetMapping("/registration")
    @ApiOperation(value = "Регистрация нового пользователя")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
