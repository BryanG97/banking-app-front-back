import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountCreateComponent } from '../account-create/account-create.component';

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
  }

}
