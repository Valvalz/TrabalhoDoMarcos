package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Livro;
import application.model.LivroRepository;

@Controller
@RequestMapping("/Genero")

public class GeneroController {
    @Autowired
    private GeneroRepository GeneroRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", generoRepo.findAll());
        return "/genero/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/genero/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo) {
        Genero genero = new Genero();
        genero.setTitulo(titulo);

        generoRepo.save(livro);
        return "redirect:/genero/list";
    }

    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(genero.isPresent()) {
            model.addAttribute("livro", genero.get());
            return "/genero/update";
        }

        return "redirect:/genero/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") int id,
        @RequestParam("titulo") String titulo) {
        Optional<Genero> genero = generoRepo.findById(id);

        if(genero.isPresent()) {
            genero.get().setTitulo(titulo);
            generoRepo.save(genero.get());
        }

        return "redirect:/livro/list";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Livro> livro = livroRepo.findById(id);

        if(livro.isPresent()) {
            model.addAttribute("livro", livro.get());
            return "/livro/delete";
        }

        return "redirect:/livro/list";
    }
    
}
