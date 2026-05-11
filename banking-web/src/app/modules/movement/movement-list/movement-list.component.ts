import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MovementCreateComponent } from '../movement-create/movement-create.component';
import { MovementVo } from '../../../shared/vo/movement-vo';
import { MovementService } from '../../../core/movement.service';
import { ResponseVo } from '../../../shared/vo/response/response-vo';

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

  movementList: MovementVo[];

  constructor(
    private movementService: MovementService,
  ) {
    this.movementList = [];
   }

  ngOnInit(): void {
        this.getMovementList();
  }
     
  /**
  * Method to get the client list
  */
  getMovementList(){
    this.movementService.getAllMovements().subscribe((responde: ResponseVo) =>{
      if(responde.data){
        this.movementList = responde.data;
      }
    });
  }

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
    this.getMovementList();
  }

}
