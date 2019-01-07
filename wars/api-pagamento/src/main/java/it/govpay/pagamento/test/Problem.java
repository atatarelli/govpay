package it.govpay.pagamento.test;

import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Problem  {
  
  @Schema(example = "https://tools.ietf.org/html/rfc7231#section-6.6.4", description = "An absolute URI that identifies the problem type.  When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML). ")
 /**
   * An absolute URI that identifies the problem type.  When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML).   
  **/
  private String type = "about:blank";
  
  @Schema(description = "A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non technical stakeholders and not localized); example: Service Unavailable ")
 /**
   * A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non technical stakeholders and not localized); example: Service Unavailable   
  **/
  private String title = null;
  
  @Schema(example = "503", description = "The HTTP status code generated by the origin server for this occurrence of the problem. ")
 /**
   * The HTTP status code generated by the origin server for this occurrence of the problem.   
  **/
  private Integer status = null;
  
  @Schema(example = "Connection to database timed out", description = "A human readable explanation specific to this occurrence of the problem. ")
 /**
   * A human readable explanation specific to this occurrence of the problem.   
  **/
  private String detail = null;
  
  @Schema(description = "An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced. ")
 /**
   * An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced.   
  **/
  private String instance = null;
 /**
   * An absolute URI that identifies the problem type.  When dereferenced, it SHOULD provide human-readable documentation for the problem type (e.g., using HTML). 
   * @return type
  **/
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Problem type(String type) {
    this.type = type;
    return this;
  }

 /**
   * A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non technical stakeholders and not localized); example: Service Unavailable 
   * @return title
  **/
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Problem title(String title) {
    this.title = title;
    return this;
  }

 /**
   * The HTTP status code generated by the origin server for this occurrence of the problem. 
   * minimum: 100
   * maximum: 600
   * @return status
  **/
  @JsonProperty("status")
 @Min(100) @Max(600)  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Problem status(Integer status) {
    this.status = status;
    return this;
  }

 /**
   * A human readable explanation specific to this occurrence of the problem. 
   * @return detail
  **/
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Problem detail(String detail) {
    this.detail = detail;
    return this;
  }

 /**
   * An absolute URI that identifies the specific occurrence of the problem. It may or may not yield further information if dereferenced. 
   * @return instance
  **/
  @JsonProperty("instance")
  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  public Problem instance(String instance) {
    this.instance = instance;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Problem {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
