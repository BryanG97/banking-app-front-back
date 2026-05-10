import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MovementVo } from '../../../shared/vo/movement-vo';
import { AccountVo } from '../../../shared/vo/account-vo';
import { ClientVo } from '../../../shared/vo/client-vo';
import { ClientService } from '../../../core/client.service';
import { ResponseVo } from '../../../shared/vo/response/response-vo';
import { AccountService } from '../../../core/account.service';
import { MovementService } from '../../../core/movement.service';

@Component({
  selector: 'app-movement-create',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './movement-create.component.html',
  styleUrl: './movement-create.component.scss'
})
export class MovementCreateComponent {

  @Output() formCancelled = new EventEmitter<void>();
  @Output() reloadList = new EventEmitter<void>();

  movement: MovementVo;
  clientList: ClientVo[];
  accountList: AccountVo[];

  clientId: number;

  constructor(
    private clientService: ClientService,
    private accountService: AccountService,
    private movementService: MovementService,
  ) {
    this.movement = new MovementVo();
    this.movement.account = new AccountVo();
    this.clientList = [];
    this.clientId = 0;
    this.accountList = [];
  }

  ngOnInit(): void {
      this.getAllClients();
    }
  
    /**
     * Method to get all clients
     */
    getAllClients(){
      this.clientService.getAllClients().subscribe((response: ResponseVo) => {
        if(response.data){
          this.clientList = response.data;
        }
      });
    }

    getAccount(){
      this.accountService.findByClientClientId(this.clientId).subscribe((response: ResponseVo) => {
        if(response.data){
          this.accountList = response.data;
        }
      });
    }


  /**
   * Method to create movement
   */
  clickForm(){
    this.movementService.saveMovement(this.movement).subscribe((response: ResponseVo) => {
      if(response.message){
        alert(response.message);
        if(response.data){
          this.reloadList.emit();
          this.formCancelled.emit();
        }
      }
    });
  }

  /**
   * Method to cancel form
   */
  cancelForm(){
    this.formCancelled.emit();
  }

}
