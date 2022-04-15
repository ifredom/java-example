# mybatis

- @MapperScan
- @TableField(fill = FieldFill.INSERT)  自动填充需要实现类
- @TableField(exist = false)
  @Builder  当 Entity 使用 @Builder 注解时,无法 new Entity()
- 
```java
@Builder
class StudentEntity implements Serializable {}

public class T {
    @Test
    public void save() {
        // 当Entity使用 @Builder 注解时
        StudentEntity student = StudentEntity.builder().name("小华").age(87).build();
        
//        StudentEntity student = new StudentEntity();
//        student.setName("小华");
//        student.setAge(87);
        studentService.save(student);
    }
}
```
