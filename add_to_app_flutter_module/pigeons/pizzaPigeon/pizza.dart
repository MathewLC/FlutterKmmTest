import 'package:pigeon/pigeon.dart';

class Pizza {
  final String name;
  final int id;

  Pizza(this.name,this.id);

}

@HostApi()
abstract class PizzaHostApi{
  @async
  List<Pizza> getPizzas();
}