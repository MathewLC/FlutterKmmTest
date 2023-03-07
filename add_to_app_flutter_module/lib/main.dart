import 'package:add_to_app_flutter_module/page1.dart';
import 'package:add_to_app_flutter_module/page2.dart';
import 'package:flutter/material.dart';
import 'dart:ui';

void main() => runApp(chooseWidget(window.defaultRouteName));

@pragma('vm:entry-point')
void page2() => runApp(Page2());

Widget chooseWidget(String route) {
  switch (route) {
    // name of the route defined in the host app
    case 'page1':
      return Page1();
    case 'page2':
      return Page2();
    default:
      return Center(
        child: Text('O estag desligou o servidor'),
      );
  }
}
