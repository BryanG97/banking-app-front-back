import { AccountVo } from "./account-vo";


export class MovementVo{

    movementId!: number;

    movementDate!: Date;

    movementType!: string;

    movementValue!: number;

    movementBalance!: number;

    account!: AccountVo;

}