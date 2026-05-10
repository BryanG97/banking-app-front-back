import { CommonModule } from '@angular/common';
import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountVo } from '../../../shared/vo/account-vo';
import { ClientService } from '../../../core/client.service';
import { ClientVo } from '../../../shared/vo/client-vo';
import { ResponseVo } from '../../../shared/vo/response/response-vo';
import { AccountService } from '../../../core/account.service';

@Component({
  selector: 'app-account-create',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './account-create.component.html',
  styleUrl: './account-create.component.scss'
})
export class AccountCreateComponent {

  @Output() formCancelled = new EventEmitter<void>();
  @Output() reloadList = new EventEmitter<void>();

  account: AccountVo;
  clientList: ClientVo[];


  constructor(
    private clientService: ClientService,
    private accountService: AccountService,
  ) {
    this.account = new AccountVo();
    this.account.client = new ClientVo();
    this.clientList = [];

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

  /**
   * Method to create account
   */
  clickForm(){
    this.accountService.saveAccount(this.account).subscribe((response: ResponseVo) => {
      if(response.message){
        alert(response.message);
        if(response.data){
          this.formCancelled.emit();
          this.reloadList.emit();
        }
      }else{
        alert('Error al crear la cuenta.');
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
