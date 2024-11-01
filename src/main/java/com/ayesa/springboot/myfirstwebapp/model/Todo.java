package com.ayesa.springboot.myfirstwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents a "Todo" task in the system. This class models the details of a task, including
 * its unique ID, associated user, description, target completion date, and completion status.
 * <p>
 * The class is annotated with Lombok annotations for automatic generation of constructors,
 * getters, setters, and standard methods like equals, hashCode, and toString, which improves
 * readability and maintainability.
 * </p>
 *
 * <p><b>Usage example:</b></p>
 * <pre>
 *     Todo task = Todo.builder()
 *                     .id(1)
 *                     .username("user1")
 *                     .description("Complete documentation")
 *                     .targetDate(LocalDate.now().plusDays(5))
 *                     .done(false)
 *                     .build();
 * </pre>
 *
 * @author architecture - rperezv
 * @version 27/10/2024 - 17:19
 * @since jdk 1.17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    /**
     * Unique identifier for the task.
     */
    private int id;

    /**
     * Username associated with the task.
     */
    private String username;

    /**
     * Detailed description of the task.
     */
    private String description;

    /**
     * Target date by which the task should be completed.
     */
    private LocalDate targetDate;

    /**
     * Completion status of the task.
     * <ul>
     *     <li><b>true</b>: Task is completed.</li>
     *     <li><b>false</b>: Task is not completed.</li>
     * </ul>
     */
    private boolean done;

}
