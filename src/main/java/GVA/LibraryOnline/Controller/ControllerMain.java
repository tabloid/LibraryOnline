package GVA.LibraryOnline.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by v.herasymenko on 3/25/2016.
 */

@Controller
public class ControllerMain {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/web/client");
        return mav;
    }
}
