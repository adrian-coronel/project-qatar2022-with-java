function horastra(){
  var ht=parseInt(document.getElementById("horas").value);
  var pgoras=parseInt(document.getElementById("pagohoras").value);
  if(ht>1 && ht<=40){
      var result=ht*pgoras;
  }else if(ht>40 && ht<=48){
      var result=pgoras*((ht-40)*2) + (40*pgoras);
  }else if(ht>48){
      var result=pgoras*((ht-48)*3) + pgoras*((ht*8)*2) + (40*pgoras);
  }

  document.getElementById("res").value=(result);
}