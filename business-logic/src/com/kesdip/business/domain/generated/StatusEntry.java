package com.kesdip.business.domain.generated;
// Generated 15 Δεκ 2008 10:07:07 μμ by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * 			Domain object for the 'Parameter' entity. Auto-generated code.
 * 			<strong>Do not modify manually.</strong> @author
 * 			gerogias
 * 		
 */
public class StatusEntry  implements java.io.Serializable {


     /**
      * 				Primary, surrogate key.
 * 			
     */
     private Long id;
     /**
      * 				The timestamp of the event.
 * 			
     */
     private Date timestamp;
     /**
      * 				The value of the parameter.
 * 			
     */
     private short status;

    public StatusEntry() {
    }

    public StatusEntry(Date timestamp, short status) {
       this.timestamp = timestamp;
       this.status = status;
    }
   
    /**       
     *      * 				Primary, surrogate key.
     * 			
     */
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    /**       
     *      * 				The timestamp of the event.
     * 			
     */
    public Date getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    /**       
     *      * 				The value of the parameter.
     * 			
     */
    public short getStatus() {
        return this.status;
    }
    
    public void setStatus(short status) {
        this.status = status;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("id").append("='").append(getId()).append("' ");			
      buffer.append("timestamp").append("='").append(getTimestamp()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StatusEntry) ) return false;
		 StatusEntry castOther = ( StatusEntry ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         
         
         return result;
   }   


}

