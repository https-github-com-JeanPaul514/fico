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

import pe.edu.upc.entities.Membresia;
import pe.edu.upc.service.ITipoMembreciaService;
import pe.edu.upc.service.IMembresiaService;

@Controller
@RequestMapping("/membresia")
public class MembresiaController {
	@Autowired
	private IMembresiaService sService;
	@Autowired
	private ITipoMembreciaService mService;

	@GetMapping("/new")
	public String newMembresia(Model model) {
		model.addAttribute("membresia", new Membresia());
		model.addAttribute("listaTipoMembresia", mService.list());
		return "membresia/membresia";
	}

	@PostMapping("/save")
	public String saveMembresia(@Valid @ModelAttribute(value = "membresia") Membresia membresia, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listaTipoMembresia", mService.list());
			return "membresia/membresia";
		} else {
			sService.insert(membresia);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/membresia/list";
		}

	}

	@GetMapping("/list")
	public String listMembresia(Model model) {
		try {
			model.addAttribute("listaMembresia", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "membresia/listMembresia";
	}

	@RequestMapping("/delete")
	public String deleteMembresia(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				sService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/membresia/list";

	}

}
