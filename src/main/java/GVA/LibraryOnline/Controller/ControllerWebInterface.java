package GVA.LibraryOnline.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by V.Herasymenko on 21.10.2015.
 */
@Controller
@RequestMapping(value = "/web")
public class ControllerWebInterface {

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ModelAndView getClient() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("client");
        return mav;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdmin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        return mav;
    }
}
