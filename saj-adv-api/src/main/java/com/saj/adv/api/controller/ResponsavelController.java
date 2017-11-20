package com.saj.adv.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saj.adv.api.model.entity.Responsavel;
import com.saj.adv.api.model.repository.ResponsavelRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;

@RestController
@RequestMapping("/responsavel")
@Api(tags = "CRUD Responsável")
public class ResponsavelController {

	@Autowired
	private ResponsavelRepository responsavelRepository;
	
    @ApiOperation(value = "List responsável")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable<Responsavel> list(Model model) {
		Iterable<Responsavel> responsavelList = responsavelRepository.findAll();
		return responsavelList;
	}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "Add responsável")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Responsavel responsavel){
        responsavelRepository.save(responsavel);
        return new ResponseEntity("Saved successfully", HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "Update responsável")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody Responsavel responsavel){
        Responsavel responsavelUpdate = responsavelRepository.findOne(id);
       
        responsavelUpdate.setNome(responsavel.getNome());
        responsavelUpdate.setCpf(responsavel.getCpf());
        responsavelUpdate.setEmail(responsavel.getEmail());
        responsavelUpdate.setFoto(responsavel.getFoto());
        
        responsavelRepository.save(responsavelUpdate);
        return new ResponseEntity("Updated successfully", HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "Delete responsável")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        responsavelRepository.delete(id);
        return new ResponseEntity("Deleted successfully", HttpStatus.OK);
    }
}
