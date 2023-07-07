package pe.idat.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="productos")
public class Producto implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productoId; //columna -> producto_id
	
	@Column
	private String nombre;
	
	@Column
	private Double precio;
	
	@Column
	private String marca;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fvencimiento;
	
	@Column
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false)
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="productos_proveedores",
		joinColumns=@JoinColumn(name="producto_id"),
		inverseJoinColumns=@JoinColumn(name="proveedor_id"))	
	private Set<Proveedor> itemsProveedor=new HashSet<>();
	
	//constructor sin propiedades
	public Producto() {		
	}
	
	//constructor con propiedades
	public Producto(Integer productoId, String nombre, Double precio, String marca, LocalDate fvencimiento, Integer stock) {
		this.productoId = productoId;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.fvencimiento = fvencimiento;
		this.stock = stock;
	}
	
	//encapsulamiento de propiedades
	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getFvencimiento() {
		return fvencimiento;
	}

	public void setFvencimiento(LocalDate fvencimiento) {
		this.fvencimiento = fvencimiento;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Proveedor> getItemsProveedor() {
		return itemsProveedor;
	}

	public void setItemsProveedor(Set<Proveedor> itemsProveedor) {
		this.itemsProveedor = itemsProveedor;
	}
}
