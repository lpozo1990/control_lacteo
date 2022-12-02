
   async function makeRequest(id, nombre, token, header, url, type, redirectTo){
   let confirmation = window.confirm(`Desea eliminar a ${nombre}?`);
   if(confirmation) {
     $.ajax({
       url: url,
       type : type,
   data: token,
   beforeSend:function(xhr){
        xhr.setRequestHeader(header, token);
   },
   success : function(data) { 
       window.location =redirectTo;    
   }, 
   error : function(data) {
       console.log(data);
   }
     })
   }

 }

   async function makeRequestPost(token, header, url, data, redirectTo){
     $.ajax({
       url: url,
       contentType: "application/json",
       data: JSON.stringify(data),
       dataType: 'json',
       type : 'POST',
   beforeSend:function(xhr){
        xhr.setRequestHeader(header, token);
   },
   success : function(data) { 
      //  window.location =redirectTo;    
   }, 
   error : function(data) {
       console.log(data);
   }
     })

 }