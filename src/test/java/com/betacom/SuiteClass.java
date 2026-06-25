package com.betacom;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.betacom.Bici.BiciTest;
import com.betacom.alimentazione.AlimentazioneTest;
import com.betacom.categoria.CategoriaTest;
import com.betacom.freno.FrenoTest;
import com.betacom.macchina.MacchinaTest;
import com.betacom.moto.MotoTest;
import com.betacom.sospensione.SospensioneTest;
import com.betacom.tipoveicolo.TipoVeicoloTest;
import com.betacom.veicolo.VeicoloTest;

@Suite
@SelectClasses({
	TipoVeicoloTest.class,
	SospensioneTest.class,
	AlimentazioneTest.class,
	CategoriaTest.class,
	FrenoTest.class,
	BiciTest.class,
	MotoTest.class,
	MacchinaTest.class,
	VeicoloTest.class
	
})
public class SuiteClass {

}