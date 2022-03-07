package org.project.blindings;

import lombok.Data;

@Data
public class UnlockAccRequest {
   private String email;
   private String tempPwd;
   public String newPwd;
   private String confirmPwd; 
}
