package ingsoft1920.em.Controller;

import java.util.List;
import java.util.Map;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.em.Beans.ActividadBean;
import ingsoft1920.em.Beans.BajaBean;
import ingsoft1920.em.Beans.DatoEmpleadoBean;
import ingsoft1920.em.DAO.BajaDAO;
import ingsoft1920.em.DAO.EmpleadoDAO;
import ingsoft1920.em.DAO.TurnoDAO;
import ingsoft1920.em.Model.BajaModel;
import ingsoft1920.em.Model.TurnoModel;


@Controller 

public class BajasController {

final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	@GetMapping("/menu6")
	public String loginp(Model model) {
		return "menu";
	}
	
	@PostMapping("/menu6")
	public String menup(Model model) {
		return "menu";
	}
	
	@GetMapping("/nomina6")
	public String nominap1(Model model) {
		return "nomina";
	}
	
	@PostMapping("/nomina6")
	public String nominap(Model model) {
		return "nomina";
	}
	
	@GetMapping("/perfil6")
	public String perfilp1(Model model) {
		DatoEmpleadoBean empleado=EmpleadoDAO.sacaEmpleado(LoginController.id_empleado);
		model.addAttribute("empleado", empleado);
		return "perfilPrueba";
	}
	
	@PostMapping("/perfil6")
	public String perfilp(Model model) {
		return "perfil";
	}
	
	@GetMapping("/cerrar6")
	public String cerrarp1(Model model) {
		return "login";
	}
	
	@PostMapping("/cerrar6")
	public String cerrarp(Model model) {
		return "login";
	}

	@GetMapping("/turnos6")
	public String turnosp1(Model model) {
		List<TurnoModel> turnos=TurnoDAO.enviarTurnos();
		model.addAttribute("turnos", turnos);
		return "turnos";
	}
	
	@PostMapping("/turnos6")
	public String turnosp(Model model) {
		return "turnos";
	}
	@GetMapping("/tareas6")
	public String tareasp1(Model model) {
		List<ActividadBean> tareas=ActividadesDHO.peticionPedirTarea();
		model.addAttribute("tareas", tareas);
		return "tareaPrueba";
	}
	
	@PostMapping("/tareas6")
	public String tareasp(Model model) {
		return "tareaPrueba";
	}
	
	
	@GetMapping("/ausencias6")
	public String ausenciasp1(Model model) {
		return "ausencias";
	}
	
	@PostMapping("/ausencia6")
	public String ausenciasp(Model model) {
		return "ausencias";
	}
	
	@GetMapping("/verBaja")
	public String verBaja(Model model) {
		List<BajaModel> bajas=BajaDAO.BajaModelSacaBajas(LoginController.id_empleado);
		model.addAttribute("bajas",bajas);
		return "muestraBajas";
	}
	@PostMapping("/verBaja")
	public String verBaja1(Model model) {
		return "muestraBajas";
	}

	@GetMapping("/aniadeBaja")
	public String añadeBaja(Model model) {
		BajaBean baja=new BajaBean();
		model.addAttribute("bajaBean",baja);
		model.addAttribute("mensajeError","");
		return "bajas";
	}
	@PostMapping("/aniadeBaja")
	public String añadeBaja1(BajaBean bajaBean,Model model) {
		BajaDAO.insertaBaja(LoginController.id_empleado, bajaBean);
		int id_baja=BajaDAO.getIdBaja(LoginController.id_empleado,bajaBean);
		BajasCM.peticionPedirBaja(LoginController.id_empleado,id_baja,bajaBean);
		return "bajas";
	}
	
}