package br.com.jadielycardoso.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Schema(example = "Jailton Filho", requiredMode = RequiredMode.REQUIRED, description = "Nome do Candidato")
	private String name;

	@NotBlank
	@Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
	@Schema(example = "jailton", requiredMode = RequiredMode.REQUIRED, description = "Username do Candidato")
	private String username;

	@Email(message = "O campo [email] deve conter um e-mail válido")
	@Schema(example = "jailton@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "Email do Candidato")
	private String email;

	@Length(min = 10, max = 100)
	@Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do Candidato")
	private String password;

	@Schema(example = "Jovem Aprendiz", requiredMode = RequiredMode.REQUIRED, description = "Breve descrição do Candidato")
	private String description;
	private String curriculum;

	@CreationTimestamp
	private LocalDateTime createdAt;
}
