package br.com.furb.engenhariasoftware.test;

import br.com.furb.engenhariasoftware.bussiness.BusinessHtmlReport;
import br.com.furb.engenhariasoftware.bussiness.BusinessProject;
import br.com.furb.engenhariasoftware.bussiness.BusinessSweepSourceCode;
import br.com.furb.engenhariasoftware.entity.Project;

public class TestBusinessSweepSourceCode {

	public void testSweepSourceTraceability(){
		BusinessProject bp = new BusinessProject();
		BusinessSweepSourceCode bsc = new BusinessSweepSourceCode();
		BusinessHtmlReport report = new BusinessHtmlReport();
		try {
			Project project = bp.getProjectById(1L);
			bsc.sweepSourceTraceability(project);
			report.generateHtmlReport(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestBusinessSweepSourceCode tbssc = new TestBusinessSweepSourceCode();
		tbssc.testSweepSourceTraceability();
	}
	
}