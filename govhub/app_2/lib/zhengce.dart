import 'package:dio/dio.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


import 'detail.dart';

class zhengce extends StatefulWidget {
  String city;

  zhengce({Key? key, required this.city}) : super(key: key);

  @override
  State<zhengce> createState() => _zhengce();
}

class _zhengce extends State<zhengce> {
  var result = [];
  String token = '';

  _getCity() async {
    var dio = Dio(BaseOptions(
      baseUrl: 'http://114.116.3.191/citys',
      connectTimeout: 5000,
      receiveTimeout: 100000,
      // 5s
      headers: {
        'city': widget.city,
        "token":token
      },
      contentType: Headers.jsonContentType,
      // Transform the response data to a String encoded with UTF8.
      // The default value is [ResponseType.JSON].
      responseType: ResponseType.json,
    ));
    Response response;
    response = await dio.post('/getAll');

    setState(() {
      result = response.data;

    });
  }

  @override
  void initState() {
    _getCity();
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: result.length,
        itemBuilder: (BuildContext ctx, int i) {
          var temp = result[i];
          return GestureDetector(
            onTap: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (BuildContext ctx) {
                    return detail(
                      url: temp['url'],
                      title: temp['title'],
                    );
                  }));
            },
            child: Container(
              margin: const EdgeInsets.all(10),
              padding: const EdgeInsets.all(10),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.blue, width: 2.0),
                borderRadius: const BorderRadius.all(
                  //  Radius.circular(150),    //圆形
                  Radius.circular(10),
                ),
              ),
              child: Column(
                children: [
                  Text(
                    result[i]['title'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    '时间:  ' + result[i]['time'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                ],
              ),
            ),
          );
        });
  }
}
