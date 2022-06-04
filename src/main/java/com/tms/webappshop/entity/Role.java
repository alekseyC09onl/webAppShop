//package com.tms.webappshop.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.Set;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "roles", schema = "shop_schema")
//public class Role implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 6934571635561246915L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "role_title")
//    private String roleTitle;
//
////    @OneToMany(mappedBy = "role")
////    private List<User> userList;
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "roleSet")
//    private Set<User> userSet;
//
//
////    @Override
////    public String getAuthority() {
////        return getRoleTitle();
////    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role = (Role) o;
//        return Objects.equals(id, role.id) && Objects.equals(roleTitle, role.roleTitle);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, roleTitle);
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", roleTitle='" + roleTitle + '\'' +
//                '}';
//    }
//}
