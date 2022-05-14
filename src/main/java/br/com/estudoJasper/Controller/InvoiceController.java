package br.com.estudoJasper.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.estudoJasper.domain.Musicas;
import br.com.estudoJasper.service.MusicasService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class InvoiceController {
	@Autowired
	private MusicasService musicasService;

	@GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> downloadInvoice() throws JRException, IOException {
		Musicas musica = new Musicas();
		for (int cont = 0; cont < this.musicasService.listar().size(); cont++) {
			musica = this.musicasService.listar().get(cont);
		}
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				this.musicasService.listar(), false);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("total", "7000");

		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream(
				"F:\\Programacao estudo\\Jasper Estudo\\br.com.projetoJasper\\src\\main\\resources\\relatorio.jrxml"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

		// JasperExportManager.exportReportToPdfFile(jasperPrint,
		// System.currentTimeMillis() + ".pdf");

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}
