import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MovementCreateComponent } from '../movement-create/movement-create.component';

@Component({
  selector: 'app-movement-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MovementCreateComponent,
  ],
  templateUrl: './movement-list.component.html',
  styleUrl: './movement-list.component.scss'
})
export class MovementListComponent {

  showCreateMovement: boolean = false;

  /**
   * Method to show create movement part
   */
  showCreateMovementModal(){
    this.showCreateMovement = true;
  }

  /**
   * Method to hide create movement part
   */
  cancelCreateMovement(){
    this.showCreateMovement = false;
  }

  /**
   * Method to reload list
   */
  reloadList(){
  }

}
