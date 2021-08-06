let Permission = {};

Permission.no = 0;
Permission.department = 1;
Permission.major = 2;
Permission.class = 4;
Permission.consumer = 8;
Permission.teacher = 16;
Permission.activity = 32;
Permission.consumerActivity = 64;
Permission.admin = 128;
Permission.visitor = 8;

Permission.permissionCount = 8;

export default Permission;
