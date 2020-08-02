# springboot-mongodb
Spring Boot + MongoDB + Spring Data

Install MongoDB and Create a database otp.

Please follow the below commands in administrator console.

> use otp
> db.item.insert({
   itemId:1,
   serialNumber:82,
   category:"Books",
   name:"MongoDB in Action"
})
> db.item.insert({
   itemId:2,
   serialNumber:20,
   category:"Mobiles",
   name:"iPhone6"
})
> db.item.insert({
   itemId:3,
   serialNumber:84,
   category:"Books",
   name:"Spring in Action"
})
> db.item.insert({
   itemId:4,
   serialNumber:24,
   category:"Mobiles",
   name:"Samsung Galaxy"
})

It will create collection named as item (table) and insert documents (rows) in it.

Before execution of springboot application you must follow above steps.

Please raise a comment if you are facing any issues.

Happy Coding !!!.
