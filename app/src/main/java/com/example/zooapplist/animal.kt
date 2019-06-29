package com.example.zooapplist

class Animal{
    var name:String?=null
    var desc:String?=null
    var image:Int?=null
    var iskiller:Boolean?=null
    constructor(name:String, desc:String, image:Int, iskiller:Boolean){
        this.name = name
        this.desc = desc
        this.image = image
        this.iskiller = iskiller
    }
}