package com.example.project.BackendSpring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="`user_role`")
public class UserRole {
    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "idrole", columnDefinition = "uniqueidentifier")
    private UUID idrole;
    @Column(name = "iduser", columnDefinition = "uniqueidentifier")
    private UUID iduser;
}
