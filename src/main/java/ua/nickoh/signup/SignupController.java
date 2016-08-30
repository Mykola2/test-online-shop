package ua.nickoh.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.nickoh.support.web.MessageHelper;
import ua.nickoh.user.User;
import ua.nickoh.user.UserService;

import javax.validation.Valid;

@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/signup";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signup")
    public String signup(Model model) {
        model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }
        User account = userService.save(signupForm.createAccount());
        userService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
