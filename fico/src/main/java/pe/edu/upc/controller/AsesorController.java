package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Asesor;
import pe.edu.upc.service.IAsesorService;

@Controller
@RequestMapping("/asesor")
public class AsesorController {
	@Autowired
	private IAsesorService mService;

	/* localhost:8082/medics/ */

	@GetMapping("/new")
	public String newAsesor(Model model) {
		model.addAttribute("asesor", new Asesor());
		return "asesor/asesor";
	}

	@PostMapping("/save")
	public String saveAsesor(@Valid @ModelAttribute(value = "asesor") Asesor asesor, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "asesor/asesor";
		} else {
			mService.insert(asesor);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/asesor/list";
		}

	}

	@GetMapping("/list")
	public String listAsesor(Model model) {
		try {
			model.addAttribute("listaAsesor", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "asesor/listAsesor";
	}

	
	
	@RequestMapping("/delete")
	public String deleteAsesor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/asesor/list";

	}

}
