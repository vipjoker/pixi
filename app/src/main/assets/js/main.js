  window.onload = function(){

    var app = new PIXI.Application(document.body.offsetWidth, document.body.offsetWidth, {backgroundColor : 0x1099bb});
document.body.appendChild(app.view);

var bunny = PIXI.Sprite.fromImage('mario.png')

// center the sprite's anchor point
bunny.anchor.set(0.5);

// move the sprite to the center of the screen
bunny.x = app.renderer.width / 2;
bunny.y = app.renderer.height / 2;

app.stage.addChild(bunny);

// Listen for animate update
app.ticker.add(function(delta) {
    // just for fun, let's rotate mr rabbit a little
    // delta is 1 if running at 100% performance
    // creates frame-independent tranformation
    bunny.rotation += 0.1 * delta;
});


    }



  function diplayJavaMsg(msg){
alert(msg);

  }

  function callTojavaFn(){

    var msg = "Calling from fefefefefJava Script " + document.body.offsetWidth;

    JsHandler.jsFnCall(msg);

  }

  function callMy(){


    console.log("Hello");
  }