package BMILIVE.BmiLive.Controller;

import BMILIVE.BmiLive.Model.Height_and_Weight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BmiController {
    /**
     * Need to fix BMI metric calculation, from meters, to Centimeters and kilograms.
     * Rounding is completed.
     */


        @GetMapping("/")
        public String showBMIForm(Model model) {
            model.addAttribute("heightWeight", new Height_and_Weight());
            model.addAttribute("bmi", null);
            return "bmi-form";
        }

        @PostMapping("/calculate-bmi")
        public String calculateBMI(@ModelAttribute("heightWeight") Height_and_Weight heightWeight, Model model) {
            double height = heightWeight.getHeight();
            double weight = heightWeight.getWeight();


            double bmi = weight / (height * height);
            bmi = Math.round(bmi * 10) / 10.0;

            model.addAttribute("bmi", bmi);
            return "bmi-form";
        }

    /**
     * Takes in a users height in inches and weight in LBS and calculates the results.
     * @param heightAndWeight
     * @param model
     * @return
     */
    @PostMapping("/calculate/bmi/height/weight")
    public String calculateBmiByHeightAndWeight(@ModelAttribute("heightWeight") Height_and_Weight heightAndWeight,Model model){
            double height = heightAndWeight.getHeight();
            double weight = heightAndWeight.getWeight();
        double bmi = (weight / (height * height)) * 703;
        bmi = Math.round(bmi);
            model.addAttribute("bmi",bmi);
            return "bmi-form";
            }
    }


