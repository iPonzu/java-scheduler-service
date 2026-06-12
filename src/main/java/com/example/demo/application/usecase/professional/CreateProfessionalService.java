// package com.example.demo.application.usecase.professional;
// package com.example.demo.application.usecase;
// import com.example.demo.application.dto.professional.CreateProfessionalCommand;
// import com.example.demo.domain.model.Professional;
// import com.example.demo.domain.ports.in.CreateProfessionalUseCase;
// import com.example.demo.domain.ports.out.ProfessionalRepositoryPort;
// import com.example.demo.domain.ports.out.UserRepositoryPort;
// import com.example.demo.domain.exception.BusinessException;
// import com.example.demo.domain.exception.ResourceNotFoundException;
// import com.example.demo.domain.model.User;
// import com.example.demo.domain.enums.ProfessionalStatus;
// import com.example.demo.domain.ports.out.ClockPort;

// public class CreateProfessionalService implements CreateProfessionalUseCase {
//     private final UserRepositoryPort userRepositoryPort;
//     private final ProfessionalRepositoryPort professionalRepositoryPort;
//     private final ClockPort clockPort;

//     public CreateProfessionalService(
//         UserRepositoryPort userRepositoryPort,
//         ProfessionalRepositoryPort professionalRepositoryPort,
//         ClockPort clockPort
//     ) {
//         this.userRepositoryPort = userRepositoryPort;
//         this.professionalRepositoryPort = professionalRepositoryPort;
//         this.clockPort = clockPort;
//     }

//     @Override
//     public ProfessionalService execute(CreateProfessionalCommand command){
//         User user = userRepositoryPort.findById(command.userId())
//             .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        
//     }
// }