package it.academy.crypto.controller;

import it.academy.crypto.models.AssetWithQuantity;
import it.academy.crypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping(value= {"", "/"})
    public String index(Model model) {
        List<AssetWithQuantity> results = cryptoService.getAssetsWithQuantity();
        for (AssetWithQuantity awt : results) {
            System.out.println(awt.getQuantity());
        }
        model.addAttribute("assetsList", results);
        return "index";
    }

}
