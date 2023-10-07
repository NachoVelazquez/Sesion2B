package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Encargado, 10f, 1f), 2530);
	}
	@Test
	void testCalculoNominaBrutavendedor() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 10f, 1f), 2030);
		
	}
	@Test
	void testCalculoNominaBrutaOtro() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 10f, 1f), -2);
	}

	@Test
	void testCalculoNominaBrutaVentasMesNegativa() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, -122, 1f), -1);
	}

	@Test
	void testCalculoNominaBrutaVentasMesMenor1000() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 0, 1), 2030);
	}

	@Test
	void testCalculoNominaBrutaVentasMesEntre1000y1500() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1100, 1), 2130);
	}

	@Test
	void testCalculoNominaBrutaVentasMesmayor1500() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1600, 1), 2230);
	}

	@Test
	void testCalculoNominaBrutaVentasHorasExtraPositivas() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1600, 2), 2260);
	}
	
	@Test
	void testCalculoNominaBrutaVentasHorasExtraNegativas() {
		assertEquals(Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, -1, 2), -1);
	}
	
	@Test
	void testCalculoNominaNetaNegativa() {
		assertEquals(Empleado.calculoNominaNeta(-200f), -1f);
	}

	@Test
	void testCalculoNominaNetaMenos2100() {
		assertEquals(Empleado.calculoNominaNeta(200f), 200f);
	}

	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		assertEquals(Empleado.calculoNominaNeta(2200), 1870);
	}
	@Test
	void testCalculoNominaNetaMayor2500() {
		assertEquals(Empleado.calculoNominaNeta(3000), 2460);
	}

}
