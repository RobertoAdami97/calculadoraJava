package br.edu.usj.ads.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String numero1, @RequestParam String numero2,
            @RequestParam String operador) {

        ModelAndView modelAndView = new ModelAndView("index");

        Double resultado = 0.0;
        Double primeiroNumero = Double.parseDouble(numero1);
        Double segundoNumero = Double.parseDouble(numero2);
        
        switch(operador) {
            case "+":
                resultado = primeiroNumero + segundoNumero;
                break;
            case "-":
                resultado = primeiroNumero - segundoNumero;
                break;
            case "*": 
                resultado = primeiroNumero * segundoNumero;
                break;
            case "/":
                resultado = primeiroNumero / segundoNumero;
                break;
            default:
                resultado = 000.0;
        }
       
        String texto = "O resultado é " + resultado;

        modelAndView.addObject("mensagem", texto);
        return modelAndView;
    }


}