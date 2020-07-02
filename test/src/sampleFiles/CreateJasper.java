public class CreateJasper{
	private ObjectFactory<Converter> converterFactory;

	@Autowired
	public CreateJasper(final ObjectFactory<Converter> converterFactory){
	   this.converterFactory = converterFactory;
	}

     // removed method comments
	public boolean jasperAsOutStream(final int type, final FullCompanyDetails companyDetails, final OutputStream outputStream)
				throws DocumentGenerationException{

	   boolean success = true;
	   try{
		     final JRBeanCollectionDataSource data  ​=   converterFactory.getObject().createReport(type, companyDetails);
		     final InputStream inputStream =
					  new ByteArrayInputStream(createJasperReportForTheTypeProvided(data, ReportType.of(type)));

		     org.apache.commons.io.IOUtils.copy(inputStream, outputStream);
	    } catch(IOException e){
		    log.error(e.getMessage(), e);
		    throw new DocumentGenerationException(e.getMessage(), e);
	    }
	   return log.traceExit(success);
	}
}