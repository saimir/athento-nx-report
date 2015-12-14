package org.athento.nuxeo.report.api.xpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.athento.nuxeo.report.api.model.OutputReport;
import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;

/**
 * Output descriptor.
 * 
 * @author victorsanchez
 * 
 */
@XObject("output")
public class OutputDescriptor {

	private Log log = LogFactory.getLog(OutputDescriptor.class);

	@XNode("@id")
	private String id;

	@XNode("@reqParam")
	private String reqParam;

	private OutputReport outputReportHandler;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XNode("class")
	public void setOutputReportHandler(Class<OutputReport> outputClass) {
		try {
			this.outputReportHandler = outputClass.newInstance();
		} catch (Exception e) {
			log.error("Unable to set output class.", e);
		}
	}

	public OutputReport getOutputReportHandler() {
		return outputReportHandler;
	}

	public String getReqParam() {
		return reqParam;
	}

	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}

}
