import 'package:add_to_app_flutter_module/pigeon.dart';
import 'package:flutter/material.dart';

class Page2 extends StatefulWidget {
  Page2({Key? key,this.pizzas = ""}):super(key: key);

  String pizzas;

  @override
  State<Page2> createState() => _Page2State();
}

class _Page2State extends State<Page2> {
  _getPizzas() async {
    final retrieved = await PizzaHostApi().getPizzas();
    setState(() {
      debugPrint("Pizzas: ${retrieved.join(", ")}");
      widget.pizzas = retrieved.map((e) => e?.name).join(", ");
    });
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _getPizzas();
  }


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or press Run > Flutter Hot Reload in a Flutter IDE). Notice that the
        // counter didn't reset back to zero; the application is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
          appBar: AppBar(
            title: Text("Page 2"),
          ),
          body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
               Text(
                  widget.pizzas,
                  style: Theme.of(context).textTheme.headlineMedium,
                ),
              ],
            ),
          )),
    );
  }
}
