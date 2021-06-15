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

import pe.edu.upc.entities.TipoMembrecia;
import pe.edu.upc.service.ITipoMembreciaService;

@Controller
@RequestMapping("/tipoMembresia")
public class TipoMembreciaController {
	@Autowired
	private ITipoMembreciaService mService;

	/* localhost:8082/tipoMembresia/ */

	@GetMapping("/new")
	public String newTipoMembresia(Model model) {
		model.addAttribute("tipoMembresia", new TipoMembrecia());
		return "tipoMembresia/tipoMembresia";
	}

	@PostMapping("/save")
	public String saveTipoMembresia(@Valid @ModelAttribute(value = "tipoMembresia") TipoMembrecia tipoMembresia, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "tipoMembresia/tipoMembresia";
		} else {
			mService.insert(tipoMembresia);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/tipoMembresia/list";
		}

	}

	@GetMapping("/list")
	public String listTipoMembresia(Model model) {
		try {
			model.addAttribute("listaTipoMembresia", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tipoMembresia/listTipoMembresia";
	}

	
	
	@RequestMapping("/delete")
	public String deleteTipoMembresia(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/tipoMembresia/list";

	}

}
