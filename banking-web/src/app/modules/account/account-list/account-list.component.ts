import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountCreateComponent } from '../account-create/account-create.component';
import { AccountVo } from '../../../shared/vo/account-vo';
import { AccountService } from '../../../core/account.service';
import { ResponseVo } from '../../../shared/vo/response/response-vo';

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    AccountCreateComponent,
  ],
  templateUrl: './account-list.component.html',
  styleUrl: './account-list.component.scss'
})
export class AccountListComponent {

  showCreateAccount: boolean = false;

  accountList: AccountVo[];

  constructor(
    private accountService: AccountService,
  ) { 
    this.accountList = [];
  }

  ngOnInit(): void {
      this.getAccountList();
    }
  
  /**
   * Method to get the client list
   */
  getAccountList(){
    this.accountService.getAllAccounts().subscribe((responde: ResponseVo) =>{
      if(responde.data){
        this.accountList = responde.data;
      }
    });
  }

  /**
   * Method to show create accout part
   */
  showCreateAccountModal(){
    this.showCreateAccount = true;
  }

  /**
   * Method to hide create accout part
   */
  hideCreateAccountModal(){
    this.showCreateAccount = false;
  }

  /**
   * Method to reload list
   */
  reloadList(){
    this.getAccountList();
  }

}

