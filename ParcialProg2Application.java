package com.example.parcial_Prog2;

import com.example.parcial_Prog2.entities.*;
import com.example.parcial_Prog2.entities.enums.*;
import com.example.parcial_Prog2.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class ParcialProg2Application {

	@Autowired
	private ImagenEmpleadoRepository imagenEmpleadoRepository;
	@Autowired
	private ImagenArticuloRepository imagenArticuloRepository;
	@Autowired
	private ImagenClienteRepository imagenClienteRepository;
	@Autowired
	private ImagenPromocionRepository imagenPromocionRepository;
	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;
	@Autowired
	private UsuarioEmpleadoRepository usuarioEmpleadoRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private LocalidadRepository localidadRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private SucursalRepository sucursalRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private PromocionRepository promocionRepository;
	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParcialProg2Application.class, args);

		System.out.println();
		System.out.println(" - BIENVENIDOS A HAMBURGUESITAS DB");
	}

	@Bean
	@Transactional
	CommandLineRunner init(ImagenEmpleadoRepository imagenEmpleadoRepository,
						   ImagenArticuloRepository imagenArticuloRepository,
						   ImagenClienteRepository imagenClienteRepository,
						   ImagenPromocionRepository imagenPromocionRepository,
						   UsuarioClienteRepository usuarioClienteRepository,
						   UsuarioEmpleadoRepository usuarioEmpleadoRepository,
						   EmpleadoRepository empleadoRepository,
						   ClienteRepository clienteRepository,
						   PaisRepository paisRepository,
						   ProvinciaRepository provinciaRepository,
						   LocalidadRepository localidadRepository,
						   DomicilioRepository domicilioRepository,
						   EmpresaRepository empresaRepository,
						   SucursalRepository sucursalRepository,
						   PedidoRepository pedidoRepository,
						   DetallePedidoRepository detallePedidoRepository,
						   CategoriaRepository categoriaRepository,
						   PromocionRepository promocionRepository,
						   UnidadMedidaRepository unidadMedidaRepository,
						   ArticuloInsumoRepository articuloInsumoRepository,
						   ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository,
						   PromocionDetalleRepository promocionDetalleRepository) {
		return args -> {

			Pais pais1 = Pais.builder()
					.nombre("Pais 1")
					.build();
			paisRepository.save(pais1);

			Provincia prov1 = Provincia.builder()
					.nombre("Provincia 1")
					.pais(pais1)
					.build();
			provinciaRepository.save(prov1);

			Localidad loc1 = Localidad.builder()
					.nombre("Localidad 1")
					.provincia(prov1)
					.build();
			localidadRepository.save(loc1);

			Domicilio dom1 = Domicilio.builder()
					.calle("Calle 1")
					.numero(1234)
					.cp(1234)
					.localidad(loc1)
					.build();
			domicilioRepository.save(dom1);
			Domicilio dom2 = Domicilio.builder()
					.calle("Calle 2")
					.numero(5678)
					.cp(5678)
					.localidad(loc1)
					.build();
			domicilioRepository.save(dom2);

			Empresa empr1 = Empresa.builder()
					.razonSocial("Empresa S.A")
					.nombre("Empresa 1")
					.cuil(12334555)
					.build();
			empresaRepository.save(empr1);

			Sucursal suc1 = Sucursal.builder()
					.nombre("Sucursal 1")
					.casaMatriz(Boolean.FALSE)
					.domicilio(dom1)
					.horarioApertura(LocalTime.of(8, 30))
					.horarioCierre(LocalTime.of(20, 30))
					.empresa(empr1)
					.build();
			sucursalRepository.save(suc1);

			ImagenPromocion imgProm1 = ImagenPromocion.builder()
					.denominacion("Imangen promo 1")
					.build();
			imagenPromocionRepository.save(imgProm1);

			ImagenPromocion imgProm2 = ImagenPromocion.builder()
					.denominacion("Imangen promo 2")
					.build();
			imagenPromocionRepository.save(imgProm2);

			ImagenCliente imgCli = ImagenCliente.builder()
					.denominacion("ImangenCliente 1")
					.build();
			imagenClienteRepository.save(imgCli);

			ImagenEmpleado imgEmp = ImagenEmpleado.builder()
					.denominacion("ImangenEmpleado 1")
					.build();
			imagenEmpleadoRepository.save(imgEmp);

			ImagenArticulo imgArt1 = ImagenArticulo.builder()
					.denominacion("ImagenArticulo 1")
					.build();
			imagenArticuloRepository.save(imgArt1);

			ImagenArticulo imgArt2 = ImagenArticulo.builder()
					.denominacion("ImagenArticulo 2")
					.build();
			imagenArticuloRepository.save(imgArt2);

			UsuarioEmpleado usEmp = UsuarioEmpleado.builder()
					.auth0Id("pass")
					.userName("user")
					.build();
			usuarioEmpleadoRepository.save(usEmp);
			UsuarioCliente usCli = UsuarioCliente.builder()
					.auth0Id("pass2")
					.userName("user2")
					.build();
			usuarioClienteRepository.save(usCli);

			Empleado em1 = Empleado.builder()
					.sucursal(suc1)
					.build();
			em1.setNombre("Cinthia");
			em1.setApellido("Rigoni");
			em1.setFechaNacimiento("1992-05-27");
			em1.setEmail("prueba@gmail.com");
			em1.setTelefono("123456");
			em1.setRol(Rol.CAJERO);
			em1.setUsuarioEmpleado(usEmp);
			em1.setImagenEmpleado(imgEmp);
			empleadoRepository.save(em1);

			Cliente cli1 = Cliente.builder().build();
			cli1.setNombre("Juan");
			cli1.setApellido("Fernandez");
			cli1.setTelefono("456789");
			cli1.setEmail("probando@gmail.com");
			cli1.setFechaNacimiento("1996-01-31");
			cli1.setImagenCliente(imgCli);
			cli1.setUsuarioCliente(usCli);
			cli1.setRol(Rol.CLIENTE);
			cli1.getDomicilios().add(dom1);
			cli1.getDomicilios().add(dom2);
			clienteRepository.save(cli1);

			Pedido ped1 = Pedido.builder()
					.fechaPedido(LocalDate.of(2023, 05, 23))
					.sucursal(suc1).cliente(cli1)
					.empleado(em1).total(250.5)
					.estado(Estado.PENDIENTE)
					.formaPago(FormaPago.EFECTIVO)
					.horaEstimadaFinalizacion(LocalTime.of(12, 55))
					.tipoEnvio(TipoEnvio.DELIVERY)
					.totalCosto(170.0)
					.build();
			pedidoRepository.save(ped1);

			DetallePedido detPed1 = DetallePedido.builder()
					.pedido(ped1)
					.cantidad(5)
					.subtotal(450.5)
					.build();
			detallePedidoRepository.save(detPed1);

			DetallePedido detPed2 = DetallePedido.builder()
					.pedido(ped1)
					.cantidad(2)
					.subtotal(300.0)
					.build();
			detallePedidoRepository.save(detPed2);

			Categoria cat1 = Categoria.builder()
					.denominacion("Categoria 1")
					.build();
			categoriaRepository.save(cat1);

			Categoria subCat1 = Categoria.builder()
					.denominacion("Subcategoria 1")
					.categoriaPadre(cat1)
					.build();
			categoriaRepository.save(subCat1);

			Categoria subCat2 = Categoria.builder()
					.denominacion("Subcategoria 2")
					.categoriaPadre(cat1)
					.build();
			categoriaRepository.save(subCat2);

			cat1.getSubcategorias().add(subCat1);
			cat1.getSubcategorias().add(subCat2);
			categoriaRepository.save(cat1);

			suc1.getCategorias().add(cat1);

			Promocion prom1 = Promocion.builder()
					.denominacion("Promocion 1")
					.descripcionDescuento("10% de descuento")
					.fechaDesde(LocalDate.of(2024, 06, 12))
					.fechaHasta(LocalDate.of(2024, 06, 25))
					.horaDesde(LocalTime.of(20, 30))
					.horaHasta(LocalTime.of(23, 30))
					.precioPromocional(2500.5)
					.tipoPromocion(TipoPromocion.HAPPY_HOUR)
					.build();
			prom1.getImagenPromociones().add(imgProm1);
			promocionRepository.save(prom1);

			Promocion prom2 = Promocion.builder()
					.denominacion("Promocion 2")
					.descripcionDescuento("15% de descuento")
					.fechaDesde(LocalDate.of(2024, 06, 12))
					.fechaHasta(LocalDate.of(2024, 06, 25))
					.horaDesde(LocalTime.of(11, 30))
					.horaHasta(LocalTime.of(14, 30))
					.precioPromocional(3000.0)
					.tipoPromocion(TipoPromocion.HAPPY_HOUR)
					.build();
			prom2.getImagenPromociones().add(imgProm2);
			promocionRepository.save(prom2);

			suc1.getPromociones().add(prom1);
			suc1.getPromociones().add(prom2);
			sucursalRepository.save(suc1);

			UnidadMedida unMedida = UnidadMedida.builder()
					.denominacion("Unidad de medida 1")
					.build();
			unidadMedidaRepository.save(unMedida);

			ArticuloInsumo artInsumo1 = ArticuloInsumo.builder()
					.denominacion("Articulo Insumo 1")
					.precioVenta(230.0)
					.precioCompra(460.5)
					.stockActual(36)
					.stockMaximo(150)
					.esParaElaborar(Boolean.TRUE)
					.categoria(cat1)
					.unidadMedida(unMedida)
					.build();
			artInsumo1.getImagenesArticulos().add(imgArt1);
			articuloInsumoRepository.save(artInsumo1);

			ArticuloManufacturado artManuf1 = ArticuloManufacturado.builder()
					.denominacion("Articulo Manufacturado 1")
					.categoria(cat1)
					.descripcion("Descripcion art manuf 1")
					.tiempoEstimadoMinutos(60)
					.preparacion("Preparacion art manuf 1")
					.unidadMedida(unMedida)
					.build();
			artManuf1.getImagenesArticulos().add(imgArt2);
			articuloManufacturadoRepository.save(artManuf1);

			ArticuloManufacturadoDetalle artManufDet1 = ArticuloManufacturadoDetalle.builder()
					.cantidad(2)
					.articuloInsumo(artInsumo1)
					.articuloManufacturado(artManuf1)
					.build();
			articuloManufacturadoDetalleRepository.save(artManufDet1);

			PromocionDetalle prDetll = PromocionDetalle.builder()
					.cantidad(15)
					.articulo(artInsumo1)
					.articulo(artManuf1)
					.promocion(prom1)
					.build();
			promocionDetalleRepository.save(prDetll);
		};
	}
}
