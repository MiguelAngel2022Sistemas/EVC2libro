package pe.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.Producto;
import pe.idat.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController
{
	@Autowired
	private ProductoService productoService;
	
	public ProductoRestController() {		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<Producto> productosDb=productoService.findAll();
		
		if(productosDb.isEmpty()) {
			return new ResponseEntity<>("¡Lista vacía!",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(productosDb,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Producto producto)
	{
		productoService.insert(producto);
		return new ResponseEntity<>("¡Producto registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{productoId}")
	public ResponseEntity<?> editar_PUT(@PathVariable Integer productoId,@RequestBody Producto producto)
	{
		Producto productoDb=productoService.findById(productoId);
		
		if(productoDb!=null)
		{
			producto.setProductoId(productoId);
			productoService.update(producto);
			
			return new ResponseEntity<>("¡Producto editado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no existe!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{productoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer productoId)
	{
		Producto productoDb=productoService.findById(productoId);
		
		if(productoDb!=null)
		{
			productoService.delete(productoId);
			return new ResponseEntity<>("¡Producto borrado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no existe!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{productoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId)
	{
		Producto productoDb=productoService.findById(productoId);
		
		if(productoDb!=null) {
			return new ResponseEntity<>(productoDb,HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>("¡Producto no existe!",HttpStatus.NOT_FOUND);
	}
}
