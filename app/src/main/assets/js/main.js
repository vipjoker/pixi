window.onload = function () {

    var app = new PIXI.Application(document.body.offsetWidth, document.body.offsetWidth, {backgroundColor: 0x1099bb});
    document.body.appendChild(app.view);

    var bunny = PIXI.Sprite.fromImage("mario.png");

// center the sprite's anchor point
    bunny.anchor.set(0.5);

// move the sprite to the center of the screen
    bunny.x = app.renderer.width / 2;
    bunny.y = app.renderer.height / 2;


















    var graphics = new PIXI.Graphics();

// set a fill and line style
    graphics.beginFill(0xFF3300);
    graphics.lineStyle(4, 0xffd900, 1);

// draw a shape
    graphics.moveTo(50,50);
    graphics.lineTo(250, 50);
    graphics.lineTo(100, 100);
    graphics.lineTo(50, 50);
    graphics.endFill();

// set a fill and a line style again and draw a rectangle
    graphics.lineStyle(2, 0x0000FF, 1);
    graphics.beginFill(0xFF700B, 1);
    graphics.drawRect(50, 250, 120, 120);

// draw a rounded rectangle
    graphics.lineStyle(2, 0xFF00FF, 1);
    graphics.beginFill(0xFF00BB, 0.25);
    graphics.drawRoundedRect(150, 450, 300, 100, 15);
    graphics.endFill();

// draw a circle, set the lineStyle to zero so the circle doesn't have an outline
    graphics.lineStyle(0);
    graphics.beginFill(0xFFFF0B, 0.5);
    graphics.drawCircle(470, 90,60);
    graphics.endFill();

    app.stage.addChild(graphics);





    app.stage.addChild(bunny);

// Listen for animate update
    app.ticker.add(function (delta) {
        bunny.rotation += 0.1 * delta;
    });

};


function diplayJavaMsg(msg) {
    alert(msg);

}

function callTojavaFn() {

    var msg = "Calling from fefefefefJava Script " + document.body.offsetWidth;
    JsHandler.jsFnCall(msg);
}

function callMy() {

    console.log("Hello");
}