
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